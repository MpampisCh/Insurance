public class Functions {
    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class Functions {

        public String readFromTheKeyboard() throws IOException {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String userInput = bufferedReader.readLine();
            return (userInput);
        }


        public void printInCsv() {
        }

        public void chooseExportFormat() {
            //TODO: ask the Export (Screen or CSV) file format. F2
        }


        public void calcFine() {
            //TODO: Take the number of UNINSURED vehicles of an owner -> calculate total fine. F4 (2/2)
        }
    }
}
