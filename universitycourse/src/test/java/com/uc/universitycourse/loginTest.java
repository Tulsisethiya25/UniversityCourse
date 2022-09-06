package com.uc.universitycourse;

	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertNotEquals;
	import static org.junit.Assert.assertNotNull;

	import java.util.List;

	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;

import com.uc.universitycourse.entities.LoginDetails;
import com.uc.universitycourse.repository.ILoginRepository;



	@SpringBootTest

 class loginTest {

		@Autowired
		ILoginRepository iLoginRepo;
		
		@Test
		void testCreate() {
			LoginDetails login = new LoginDetails();
			login.setLoginId(1);
			login.setPassword("1233");
			assertNotNull(iLoginRepo.existsLoginDetailsByLoginId(1));
			
		}
		
		@Test
		void testupdate() {
			LoginDetails l =iLoginRepo.findById(1).get();
			l.setPassword("123");;
			iLoginRepo.save(l);
			assertNotEquals("1233",iLoginRepo.findById(1).get().getPassword());
			
		}
		 
		
		
}
