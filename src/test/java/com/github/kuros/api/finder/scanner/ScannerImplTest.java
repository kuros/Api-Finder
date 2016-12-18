package com.github.kuros.api.finder.scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.controller.SimpleController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

@Deprecated
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-kuros-api-finder-context.xml")
public class ScannerImplTest {

    private static final String SCAN_PATH = "test.controller";

//    @Autowired
    private Scanner scanner;

//    @Autowired
    private ApplicationContext applicationContext;
    private List<String> packagesToScan;
    private List<String> packagesToScanOriginalCopy;

    @Before
    public void setUp() throws Exception {
        List<String> path = new ArrayList<String>();
        path.add(SCAN_PATH);

        packagesToScan = (List<String>) applicationContext.getBean(Scanner.SCANNAR_PATH);
        Collections.copy(packagesToScanOriginalCopy, packagesToScan);
        packagesToScan.clear();
        packagesToScan.add(SCAN_PATH);
    }

    @Test
    public void shouldGetListOfControllerClasses() throws Exception {

        final List<Class<?>> controllers = scanner.getControllers();
        assertTrue(controllers.contains(SimpleController.class));
    }

    @After
    public void tearDown() throws Exception {
        packagesToScan = (List<String>) applicationContext.getBean(Scanner.SCANNAR_PATH);
        packagesToScan.clear();
        Collections.copy(packagesToScan, packagesToScanOriginalCopy);
    }
}