import com.mockito.helper.MessagingEngine;
import com.mockito.service.NewsletterSender;
import com.mockito.repository.SubscribersDatabase;
import com.mockito.exception.ZeroSubscribersException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class NewsletterSenderTest {
    private SubscribersDatabase subscribersDatabaseMock;
    private MessagingEngine messagingEngineMock;

    @Before
    public void setup() {
        subscribersDatabaseMock = mock(SubscribersDatabase.class);
        messagingEngineMock = mock(MessagingEngine.class);
    }

    @Test
    public void constructorAssignsDatabase() {
        NewsletterSender newsletterSender = new NewsletterSender(subscribersDatabaseMock, messagingEngineMock);
        assertEquals(subscribersDatabaseMock, newsletterSender.getSubscribersDatabase());
    }

    @Test
    public void numberOfSubscribers() {
        NewsletterSender newsletterSender = new NewsletterSender(subscribersDatabaseMock, messagingEngineMock);
        List<String> subscribers = Arrays.asList("email1", "email2", "email3", "email4", "email5");
        when(subscribersDatabaseMock.getSubscribers()).thenReturn(subscribers);
        assertEquals(5, newsletterSender.numberOfSubscribers());
    }

    @Test(expected = ZeroSubscribersException.class)
    public void zeroSubscribersThrown() {
        NewsletterSender newsletterSender = new NewsletterSender(new SubscribersDatabase(), new MessagingEngine());
        NewsletterSender newsletterSenderSpy = spy(newsletterSender);

        when(newsletterSenderSpy.numberOfSubscribers()).thenReturn(0);
        newsletterSenderSpy.sendNewsletter("TEST SUBJECT");
    }
}
