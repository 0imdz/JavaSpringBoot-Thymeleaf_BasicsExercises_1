package com.eep.component;

import com.eep.repository.CourseJpaRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;

	private static final Log LOG=LogFactory.getLog(ExampleComponent.class);
	
	public void hola() {
		//courseJpaRepository.findByNombreOrPrecio("ismael", 1);
		LOG.info("Hola - Este es un mensaje del primer componente de ejemplo.");
	}
}
