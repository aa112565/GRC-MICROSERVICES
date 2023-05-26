package com.asymmetrix.grc.Config;

import java.io.IOException;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig
{
   private static final String RULES_CUSTOMER_RULES_DRL = "approval-workflow.drl";  
    private static final KieServices kieServices;
    
    @Bean
    public KieContainer kieContainer() {
        final KieFileSystem kieFileSystem = DroolsConfig.kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("approval-workflow.drl"));
        final KieBuilder kb = DroolsConfig.kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        final KieModule kieModule = kb.getKieModule();
        final KieContainer kieContainer = DroolsConfig.kieServices.newKieContainer(kieModule.getReleaseId());
        return kieContainer;
    }
    
    static {
        kieServices = KieServices.Factory.get();
    }
	
	
//	private KieServices kieServices = KieServices.Factory.get();
//
//	private KieFileSystem getKieFileSystem() throws IOException {
//		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//		kieFileSystem.write(ResourceFactory.newClassPathResource("approval-workflow.drl"));
//		return kieFileSystem;
//
//	}
//
//	@Bean
//	public KieContainer getKieContainer() throws IOException {
//		System.out.println("Container created...");
//		getKieRepository();
//		KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
//		kb.buildAll();
//		KieModule kieModule = kb.getKieModule();
//		KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());
//		return kContainer;
//
//	}
//
//	private void getKieRepository() {
//		final KieRepository kieRepository = kieServices.getRepository();
//		kieRepository.addKieModule(new KieModule() {
//			public ReleaseId getReleaseId() {
//				return kieRepository.getDefaultReleaseId();
//			}
//		});
//	}
//
//	@Bean
//	public KieSession getKieSession() throws IOException {
//		System.out.println("session created...");
//		return getKieContainer().newKieSession();
//
//	}
	
}
