package a2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import a2.AIException;
import a2.Chatbot;
import a2.ChatbotServer;

import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@ExtendWith(MockitoExtension.class)
public class TestChatbotServer {

    @Mock
    public Chatbot mockChatbot;

    @Mock
    public ServerSocket mockServerSocket;

    @Mock
    public Socket mockSocket;

    public ChatbotServer myServer;

    @BeforeEach
    public void setUp() {
        myServer = new ChatbotServer(mockChatbot, mockServerSocket);
    }

    @Test
    public void testOutput() throws Exception {
        when(mockServerSocket.accept()).thenReturn(mockSocket);
        OutputStream myOutputStream = new ByteArrayOutputStream();
        when(mockSocket.getOutputStream()).thenReturn(myOutputStream);

        myServer.handleOneClient();

        // verify(myServer).handleOneClient();

        assertEquals("Output\n", myOutputStream.toString());
    }

    // @Test
    // public void testHappyPathOneLine() throws Exception {
    // when(mockServerSocket.accept()).thenReturn(mockSocket);

    // InputStream s = new ByteArrayInputStream("GameBot\n".getBytes());
    // when(mockSocket.getInputStream()).thenReturn(s);

    // OutputStream myOutputStream = new ByteArrayOutputStream();
    // when(mockSocket.getOutputStream()).thenReturn(myOutputStream);

    // myServer.handleOneClient();

    // assertEquals("GameBot response\n", myOutputStream.toString());
    // }
}
