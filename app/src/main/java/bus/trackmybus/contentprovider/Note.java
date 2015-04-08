package bus.trackmybus.contentprovider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by MANOR on 3/14/2015.
 */
public class Note {

    public Note() {
    }

    public static final class Notes implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://"
                + NotesContentProvider.AUTHORITY + "/notes");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.jwei512.notes";
        public static final String NOTE_ID = "_id";
        public static final String TITLE = "title";
        public static final String TEXT = "text";

        private Notes() {
        }
    }

}
