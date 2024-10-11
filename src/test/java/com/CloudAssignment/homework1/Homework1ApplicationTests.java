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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = Controller1.class)
class Homework1ApplicationTests {

	@MockBean
	private DiskService diskService;

	@MockBean
	private MemoryService memoryService;

	@MockBean
	private CpuService cpuService;

	@MockBean
	private NetworkBandwidthService networkBandwidthService;

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void getDiskTest() {
		when(diskService.getDiskSpace()).thenReturn(new DiskDetails(495,393));
        try {
            mockMvc.perform(get("/disk"))
					.andExpect(status().isOk())
					.andExpect(content().contentType("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	@Test
	public void getMemoryTest() {
		when(memoryService.getMemoryDetails()).thenReturn(new MemoryDetails(18023,2313));
		try {
			mockMvc.perform(get("/mem"))
					.andExpect(status().isOk())
					.andExpect(content().contentType("application/json"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void getCpuTest() {
		when(cpuService.getCpuUsage()).thenReturn(new CpuUsage(54.5));
		try {
			mockMvc.perform(get("/cpu"))
					.andExpect(status().isOk())
					.andExpect(content().contentType("application/json"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void getNetworkBandwidthTest() {
		when(networkBandwidthService.getBandwidth()).thenReturn(new Bandwidth(123.45,123.56));
		try {
			mockMvc.perform(get("/net"))
					.andExpect(status().isOk())
					.andExpect(content().contentType("application/json"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
