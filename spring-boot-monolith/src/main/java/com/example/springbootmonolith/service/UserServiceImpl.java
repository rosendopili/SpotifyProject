package com.example.springbootmonolith.service;
import com.example.springbootmonolith.config.JwtUtil;
import com.example.springbootmonolith.models.Song;
import com.example.springbootmonolith.models.User;
import com.example.springbootmonolith.models.UserRole;
import com.example.springbootmonolith.repository.SongRepository;
import com.example.springbootmonolith.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    SongService songService;

    @Autowired
    SongRepository songRepository;

    @Autowired
    JwtUtil jwtUtil;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);

        if(user==null)
            throw new UsernameNotFoundException("User null");
        // Code edited to not include bCrypt
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getUserRole().getName()));

        return authorities;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public String createUser(User newUser) {
        UserRole userRole = userRoleService.getRole(newUser.getUserRole().getName());
        newUser.setUserRole(userRole);
        newUser.setPassword(newUser.getPassword());
        if(userRepository.save(newUser) != null){
            UserDetails userDetails = loadUserByUsername(newUser.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public HttpStatus deleteById(int userId) {
        return null;
    }

    @Override
    public String login(User user){
        User newUser = userRepository.findByUsername(user.getUsername());
//      Code edited to not use default bCrypt for password.
        if(newUser != null && user.getPassword().equals(newUser.getPassword())){
            UserDetails userDetails = loadUserByUsername(newUser.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

//    @Override
//    public User addSong(String title, Long songId) {
//        Song song = songRepository.findById(songId).get();
//        Title title = getTitle(title);
//        title.addSong(song);
//
//        return songRepository.save(title);
//    }

    public HttpStatus deleteById(Long userId){
        userRepository.deleteById(userId);
        return HttpStatus.OK;
    }

    @Override
    public User addSong(String title, int songId) {
        return null;
    }
}