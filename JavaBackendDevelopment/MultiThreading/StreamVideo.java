/**
 * ------------------------------------
 * Streaming Video using MultiThreading
 * ------------------------------------
 * OUTPUT : 
 * --------
 * 
****Playing Video****0
----Playing AUdio----0
****Playing Video****1
----Playing AUdio----1
****Playing Video****2
----Playing AUdio----2
****Playing Video****3
----Playing AUdio----3
****Playing Video****4
----Playing AUdio----4
****Playing Video****5
----Playing AUdio----5
****Playing Video****6
----Playing AUdio----6
****Playing Video****7
----Playing AUdio----7
****Playing Video****8
----Playing AUdio----8
****Playing Video****9
----Playing AUdio----9
****Playing Video****10
----Playing AUdio----10
*
*/
class StreamVideo{
    public static void main(String[] args) {
        Video v = new Video();
        Audio a = new Audio();

        v.setAudio(a);
        a.setVideo(v);

        Thread t1=new Thread(v,"VideoThread");
        Thread t2=new Thread(a,"AudioThread");

        t1.start();
        t2.start();
    }
}

class Video implements Runnable{
    Audio audio;
    public void setAudio(Audio audio){
        this.audio=audio;
    }
    @Override
    public void run(){
        playVideo();
    }
    public synchronized void playVideo(){
        for(int i=0; i<=10; i++){
            // STEP-2 : Video Plays
            System.out.println("****Playing Video****" + i);
            // STEP-3 : Audio is Nofified
            synchronized (audio) {
                audio.notify();
            }
            // STEP-4 : Video Waits
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("****InterruptedException****");
            }
        }
    }
}

class Audio implements Runnable{
    Video video;
    public void setVideo(Video video){
        this.video=video;
    }
    @Override
    public void run(){
        playAudio();
    }
    public synchronized void playAudio(){
        for(int i=0; i<=10; i++){
            // STEP-1 : Audio Waits
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("----InterruptedException----");
            }
            // STEP-5 : Audio Plays
            System.out.println("----Playing AUdio----" + i);
            // STEP-6 : Audio is Notified
            synchronized (video) {
                video.notify();
            }
            

        }
    }
}