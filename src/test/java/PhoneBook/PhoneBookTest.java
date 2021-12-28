package PhoneBook;
import com.phonebook.PhoneBookEntriesImply;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookEntriesImply phoneBook_Test = new PhoneBookEntriesImply();

    @Test
    public void findPhoneNumberByName() {
        Optional<String> phoneNumber = phoneBook_Test.findPhoneNumberByName("Krishna");
        assertThat(phoneNumber.get()).isEqualTo("9621729578");
    }
    @Test
    public void findPhoneNumberByName_NotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBook_Test.findPhoneNumberByName("Kris");
        phoneNumber.get();
    }
    @Test
    public void findNameByPhoneNumber(){
        Optional<String> name=phoneBook_Test.findNameByPhoneNumber("6387826567");
        assertThat(name.get()).isEqualTo("Shakti");
    }
    @Test
    public void findNameByPhoneNumber_NotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBook_Test.findNameByPhoneNumber("1234567891");
        phoneNumber.get();
    }
}
