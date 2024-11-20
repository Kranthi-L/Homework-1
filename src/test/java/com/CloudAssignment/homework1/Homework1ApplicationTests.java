package com.CloudAssignment.homework1;

import com.CloudAssignment.homework1.controllers.Controller1;
import com.CloudAssignment.homework1.formats.Bandwidth;
import com.CloudAssignment.homework1.formats.CpuUsage;
import com.CloudAssignment.homework1.formats.DiskDetails;
import com.CloudAssignment.homework1.formats.MemoryDetails;
import com.CloudAssignment.homework1.services.CpuService;
import com.CloudAssignment.homework1.services.DiskService;
import com.CloudAssignment.homework1.services.MemoryService;
import com.CloudAssignment.homework1.services.NetworkBandwidthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = Controller1.class)
@AutoConfigureMockMvc(addFilters = false)
class Homework1ApplicationTests {

	@MockBean
	private DiskService diskService;

	@MockBean
	private MemoryService memoryService;

	@MockBean
	private CpuService cpuService;

	@MockBean
	private NetworkBandwidthService networkBandwidthService;

	@MockBean
	private Controller1 controller;

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void getDiskTest() {
		when(diskService.getDiskSpace()).thenReturn(new DiskDetails(495,393));
        try {
            mockMvc.perform(get("/disk"))
					.andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	@Test
	public void getMemoryTest() throws Exception {
		when(memoryService.getMemoryDetails()).thenReturn(new MemoryDetails(18023,2313));
		try {
			mockMvc.perform(get("/mem").header("KEY", "secret"))
					.andExpect(status().isOk());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void getCpuTest() {
		when(cpuService.getCpuUsage()).thenReturn(new CpuUsage(54.5));
		try {
			mockMvc.perform(get("/cpu"))
					.andExpect(status().isOk());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void getNetworkBandwidthTest() {
		when(networkBandwidthService.getBandwidth()).thenReturn(new Bandwidth(123.45,123.56));
		try {
			mockMvc.perform(get("/net"))
					.andExpect(status().isOk());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

@SpringBootTest
@AutoConfigureMockMvc
class SecurityTest {

	@MockBean
	private DiskService diskService;

	@MockBean
	private MemoryService memoryService;

	@MockBean
	private CpuService cpuService;

	@MockBean
	private NetworkBandwidthService networkBandwidthService;

	@MockBean
	private Controller1 controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void securityTest() throws Exception {
		try {
			mockMvc.perform(get("/disk"))
					.andExpect(status().isUnauthorized());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void securityTest2() throws Exception {
		when(memoryService.getMemoryDetails()).thenReturn(new MemoryDetails(18023,2313));
		try {
			mockMvc.perform(get("/mem").header("KEY", "secret"))
					.andExpect(status().isOk());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
