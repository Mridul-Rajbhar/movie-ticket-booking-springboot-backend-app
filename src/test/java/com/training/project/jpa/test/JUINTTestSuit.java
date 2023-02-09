package com.training.project.jpa.test;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@SelectPackages({"com.training.project.repositories" , "com.training.project.services"})
@Suite
public class JUINTTestSuit {

}
