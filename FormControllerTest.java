// FormControllerTest.java

package com.medical.controller;

import com.medical.model.Patient;
import com.medical.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class FormControllerTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private FormController formController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(formController).build();
    }

    @Test
    public void testShowForm() throws Exception {
        mockMvc.perform(get("/form"))
                .andExpect(status().isOk())
                .andExpect(view().name("form"))
                .andExpect(model().attributeExists("patient"))
                .andExpect(model().attribute("patient", new Patient()));
    }

    @Test
    public void testSubmitForm() throws Exception {
        Patient patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setAge(30);  // Set the age
        patient.setSex("Male");  // Set the sex
        patient.setPhoneNumber("123456789");  // Set the phone number
        patient.setEmergencyContact("Emergency Contact");  // Set the emergency contact
        patient.setSymptoms("Symptoms");  // Set the symptoms
        patient.setSeverity(5);  // Set the severity

        mockMvc.perform(post("/form")
                .flashAttr("patient", patient))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/table"));

        // You can add additional assertions based on the expected behavior of your controller
    }
}
