package com.temelt.issuemanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class AppInitializator implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("");
//        UserDetails u = kullaniciService.loadUserByUsername("11111111111");
//
//        if (u == null) {
//            Kullanici kullanici = new Kullanici();
//            kullanici.setTcKimlikNumarasi("11111111111");
//            kullanici.setSifre(new BCryptPasswordEncoder().encode("11111111111"));
//            kullanici.setAdi("Admin");
//            kullanici.setSoyadi("Admin");
//            kullanici.setEmail("admin@localhost");
//            kullanici.setTelefon("0000000000");
//            kullanici.setLoginSifreDegistirsin(false);
//            kullanici.setKullaniciRol(KullaniciRol.ADMIN);
//            String s =  java.util.UUID.randomUUID().toString().substring(0, 8);
//            kullanici.setKullaniciKodu(s);
//            kullaniciService.save(kullanici);
        }
    }



