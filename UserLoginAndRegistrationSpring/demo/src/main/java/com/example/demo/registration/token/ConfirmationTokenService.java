package com.example.demo.registration.token;

import com.example.demo.appuser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        Optional<ConfirmationToken> oldToken = confirmationTokenRepository
                .findConfirmationTokenByAppUser(token.getAppUser());
        if (oldToken.isPresent()) {
            confirmationTokenRepository.updateConfirmationTokenById(
                    oldToken.get().getId(),
                    token.getToken(),
                    token.getCreatedAt(),
                    token.getExpiresAt());
        } else {
            confirmationTokenRepository.save(token);
        }
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public Optional<ConfirmationToken> getTokenByAppUser(AppUser appUser) {
        Optional<ConfirmationToken> confirmationTokensByAppUser = confirmationTokenRepository.findConfirmationTokenByAppUser(appUser);
        System.out.println(confirmationTokensByAppUser);
        return confirmationTokensByAppUser;
    }


    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token,
                LocalDateTime.now());
    }
}
