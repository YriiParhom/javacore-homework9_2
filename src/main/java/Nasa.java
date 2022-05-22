import com.fasterxml.jackson.annotation.JsonProperty;

public class Nasa {
    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String mediaType;
    private String serviceVersion;
    private String title;
    private String url;

    public Nasa(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return mediaType;
    }

    public String getService_version() {
        return serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "NASA \n { \n" +
                "copyright = " + copyright + "\n" +
                "date = " + date + "\n" +
                "explanation = " + explanation + "\n" +
                "hdurl = " + hdurl + "\n" +
                "media_type = " + mediaType + "\n" +
                "service_version = " + serviceVersion + "\n" +
                "title = " + title + "\n" +
                "url = " + url + "\n" +
                '}';
    }
}
