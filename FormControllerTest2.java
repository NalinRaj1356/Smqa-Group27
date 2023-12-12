package com.medical.controller;

import com.medical.model.Patient;
import com.medical.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;

class FormControllerTest2 {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private FormController formController;

    @Test
    void testShowForm() {
        // Arrange
        Model model = mock(Model.class);

        // Act
        String viewName = formController.showForm(model);

        // Assert
        assert viewName.equals("form");
        verify(model).addAttribute(eq("patient"), any(Patient.class));
    }

    @Test
    void testSubmitForm() {
        // Arrange
        Patient patient = new Patient();
        BindingResult bindingResult = mock(BindingResult.class);

        // Act
        String viewName = formController.submitForm(patient, bindingResult);

        // Assert
        assert viewName.equals("redirect:/table");
        verify(bindingResult, never()).hasErrors();
        verify(patientService).savePatient(patient);
    }
}
