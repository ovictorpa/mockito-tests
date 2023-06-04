import org.junit.Test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


public class ClientApiTestMockito {

    @Test
    public void testPerformRequest() {
        CatApiRequest catApiRequestMock = mock(CatApiRequest.class);
        ClientApi client = new ClientApi(catApiRequestMock);
        String jsonFilePath = "response.json";

        client.performRequest(jsonFilePath);
        verify(catApiRequestMock).makeApiResponse(jsonFilePath);
    }

    @Test
    public void testPerformRequestSuccessfulRequest() {
        CatApiRequest catApiRequestMock = mock(CatApiRequest.class);
        ClientApi client = new ClientApi(catApiRequestMock);
        String jsonFilePath = "response.json";

        doNothing().when(catApiRequestMock).makeApiResponse(jsonFilePath);

        client.performRequest(jsonFilePath);
        verify(catApiRequestMock).makeApiResponse(jsonFilePath);

        assertTrue(client.isRequestSuccessful());
    }

    @Test
    public void testPerformRequestFailedRequest() {
        CatApiRequest catApiRequestMock = mock(CatApiRequest.class);
        ClientApi client = new ClientApi(catApiRequestMock);
        String jsonFilePath = "response.json";

        doThrow(new RuntimeException("API request failed")).when(catApiRequestMock).makeApiResponse(jsonFilePath);

        client.performRequest(jsonFilePath);
        verify(catApiRequestMock).makeApiResponse(jsonFilePath);

        assertFalse(client.isRequestSuccessful());
    }
}