/**
 *
 */
package com.pattern.adapter;

/**
 * @author pche0001
 *
 */
public class VlcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing vlc file. Name: " + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// do nothing
	}

}
