package io.cloudslang.content.vmware.actions.guest;

import io.cloudslang.content.vmware.entities.GuestInputs;
import io.cloudslang.content.vmware.entities.VmInputs;
import io.cloudslang.content.vmware.entities.http.HttpInputs;
import io.cloudslang.content.vmware.services.GuestService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * Created by Mihai Tusa.
 * 3/30/2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CustomizeLinuxGuest.class)
public class CustomizeLinuxGuestTest {
    private CustomizeLinuxGuest linuxGuest;

    @Before
    public void init() {
        linuxGuest = new CustomizeLinuxGuest();
    }

    @After
    public void tearDown() {
        linuxGuest = null;
    }

    @Mock
    private GuestService guestServiceMock;

    @Test
    public void customizeLinuxGuestSuccess() throws Exception {
        Map<String, String> resultMap = new HashMap<>();
        whenNew(GuestService.class).withNoArguments().thenReturn(guestServiceMock);
        when(guestServiceMock.customizeLinuxVM(any(HttpInputs.class), any(VmInputs.class), any(GuestInputs.class))).thenReturn(resultMap);

        resultMap = linuxGuest.customizeLinuxGuest("", "", "", "", "", "", "", "", "", "", "", "", "", "");

        verify(guestServiceMock, times(1)).customizeLinuxVM(any(HttpInputs.class), any(VmInputs.class), any(GuestInputs.class));

        assertNotNull(resultMap);
    }

    @Test
    public void customizeLinuxGuestProtocolFailure() throws Exception {
        Map<String, String> resultMap = linuxGuest.customizeLinuxGuest("", "", "myProtocol", "", "", "", "", "", "", "", "", "", "", "");

        verify(guestServiceMock, never()).customizeLinuxVM(any(HttpInputs.class), any(VmInputs.class), any(GuestInputs.class));

        assertNotNull(resultMap);
        assertEquals(-1, Integer.parseInt(resultMap.get("returnCode")));
        assertEquals("Unsupported protocol value: [myProtocol]. Valid values are: https, http.", resultMap.get("returnResult"));
    }
}