package config;

public class WebConfig {
    private int port;
    private String webRoot;

    public WebConfig(int port, String webRoot){
        this.port = port;
        this.webRoot= webRoot;
    }

    public WebConfig(){}

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return this.port;
    }

    public void setWebConfig(String webRoot) {
        this.webRoot= webRoot;
    }

    public String getWebRoot(){
        return this.webRoot;
    }
}
