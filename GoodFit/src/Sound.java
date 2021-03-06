
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	private boolean released = false;
	private Clip clip = null;
	private boolean playing = false;
	
	public Sound(File f) {
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(f);
			clip = AudioSystem.getClip();
			clip.open(stream);
			clip.addLineListener(new Listener());
			released = true;
		} catch(IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
			exc.printStackTrace();
			released = false;
		}
	}

	//true ���� ���� ������� ��������, false ���� ��������� ������
	public boolean isReleased() {
		return released;
	}
	
	//������������� �� ���� � ������ ������
	public boolean isPlaying() {
		return playing;
	}

	//������
	/*
	  breakOld ���������� ���������, ���� ���� ��� ��������
	  ���� reakOld==true, � ���� ����� ������� � ������� ������
	  ����� ������ �� ���������
	*/
	public void play(boolean breakOld) {
		if (released) {
			if (breakOld) {
				clip.stop();
				clip.setFramePosition(0);
				clip.start();
				playing = true;
			} else if (!isPlaying()) {
				clip.setFramePosition(0);
				clip.start();
				playing = true;
			}
		}
	}
	
	//�� �� �����, ��� � play(true)
	public void play() {
		play(true);
	}
	
	//������������� ���������������
	public void stop() {
		if (playing) {
			clip.stop();
		}
	}

	
	
	
	//���������� ��������� ������������ �����
	public void join() {
		if (!released) return;
		synchronized(clip) {
			try {
				while (playing) clip.wait();
			} catch (InterruptedException exc) {}
		}
	}
	
	//����������� �����, ��� ��������
	public static Sound playSound(String s) {
		File f = new File(s);
		Sound snd = new Sound(f);
		snd.play();
		return snd;
	}

	private class Listener implements LineListener {
		public void update(LineEvent ev) {
			if (ev.getType() == LineEvent.Type.STOP) {
				playing = false;
				synchronized(clip) {
					clip.notify();
				}
			}
		}
	}
}