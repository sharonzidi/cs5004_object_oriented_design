package problem2;

import java.util.List;

/**
 * The type Band.
 */
public class Band extends Group {
    private String bandName;
    private List<RecordingArtist> members;

    /**
     * Instantiates a new Band.
     *
     * @param bandName         the band name
     * @param recordingArtists the recording artists
     */
    public Band(String bandName, List<RecordingArtist> recordingArtists) {
        super(recordingArtists);
        this.bandName = bandName;
        this.members = recordingArtists;
    }

    /**
     * Gets band name.
     *
     * @return the band name
     */
    public String getBandName() {
        return bandName;
    }

    /**
     * Gets members.
     *
     * @return the members
     */
    public List<RecordingArtist> getMembers() {
        return members;
    }

    @Override
    public CreatorType getType() {
        return CreatorType.Band;
    }
}
