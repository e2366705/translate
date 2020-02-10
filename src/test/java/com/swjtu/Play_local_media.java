package com.swjtu;



import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;


/**
 * @author YXB
 * @date 2020/2/10 15:01
 */
public class Play_local_media {


    /*
            播放本地媒体文件
     */


    @Test
    public void PlayMusic() throws MalformedURLException, InterruptedException, JavaLayerException, FileNotFoundException {
        Player player;
        File music;

        for (int i = 0; i < 2; i++) {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream("C:\\Users\\SpringBoot\\IdeaProjects\\translate\\src\\main\\resources\\Static\\Audio_TTS\\今天上班堵车了.mp3"));
            player = new Player(buffer);
            player.play();
        }

    }
}
