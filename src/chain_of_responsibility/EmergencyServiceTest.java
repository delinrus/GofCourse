package chain_of_responsibility;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmergencyServiceTest {

    private EmergencyService service;
    private ServiceMock serviceMock;

    @Before
    public void setUp() {
        serviceMock = new ServiceMock();
        service = new FirefightingService(serviceMock::callFirefighters);
        service.linkWith(new MedicalService(serviceMock::callMedics))
                .linkWith( new PoliceService(serviceMock::callPolice));
    }

    @Test
    public void policeAndFireMedicsCalled() {
        service.check("There is a riot in the city center, some people could get injury");
        assertEquals(2, serviceMock.getServiceCallCount());
        assertTrue(serviceMock.isPoliceCalled());
        assertTrue(serviceMock.isMedicsCalled());
    }

    @Test
    public void firefightersCalled() {
        service.check("Anonymous call reported smoke in the old warehouse");
        assertEquals(1, serviceMock.getServiceCallCount());
        assertTrue(serviceMock.isFirefightersCalled());
    }

    private class ServiceMock {
        private int serviceCallCount = 0;
        private boolean isPoliceCalled = false;
        private boolean isMedicsCalled = false;
        private boolean isFirefightersCalled = false;

        private void callPolice() {
            serviceCallCount++;
            isPoliceCalled = true;
        }

        private void callMedics() {
            serviceCallCount++;
            isMedicsCalled = true;
        }

        private void callFirefighters() {
            serviceCallCount++;
            isFirefightersCalled = true;
        }

        public int getServiceCallCount() {
            return serviceCallCount;
        }

        public boolean isPoliceCalled() {
            return isPoliceCalled;
        }

        public boolean isMedicsCalled() {
            return isMedicsCalled;
        }

        public boolean isFirefightersCalled() {
            return isFirefightersCalled;
        }
    }
}