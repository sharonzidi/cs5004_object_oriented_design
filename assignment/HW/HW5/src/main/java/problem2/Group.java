package problem2;

import java.util.List;

/**
 * The type Group.
 */
public abstract class Group implements ICreator {
    /**
     * The Recording artists.
     */
    protected List<RecordingArtist> recordingArtists;

    /**
     * Instantiates a new Group.
     *
     * @param list the list
     */
    public Group(List<RecordingArtist> list) {
        this.recordingArtists = list;
    }

}
