package com.springboot.upworkproject.virusrestapi.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springboot.upworkproject.virusrestapi.model.Symptoms;
import com.springboot.upworkproject.virusrestapi.model.Virus;

public class Client {
	
	private static final String BASE_URL = "http://localhost:8080/api/service/virus";
	
	private static final String RUD_VIRUS_BY_ID = "http://localhost:8080/api/service/virus/{id}";
	
	private static final String RUD_SYMPTOMS_BY_ID = "http://localhost:8080/api/service/virus/{v_id}/symptoms/{s_id}";
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String args[]) {
		Virus vir = insertVirus();
		getAllVirus();
		getVirusByID(vir.getIdVirus());
		getVirusByIDButNotFound();
		Symptoms symp = insertSymptons(vir.getIdVirus());
		getAllSymp(vir.getIdVirus());
		getSymptonByID(vir.getIdVirus(), symp.getIdSymptoms());
		getAllSymp(vir.getIdVirus());
		getSymptonByID(vir.getIdVirus(), symp.getIdSymptoms());
		updateSymptoms(vir.getIdVirus(), symp);
		deleteSymptomsByID(vir.getIdVirus(), symp.getIdSymptoms());
		updateVirus(vir);
		deleteVirusByID(vir);

	}
	
	private static void getAllVirus() {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", header); 
		
		ResponseEntity<String> result = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
	}
	
	private static void getVirusByID(Long id) {
		Map<String, Long> param = new HashMap<>();
		param.put("id", id);

		Virus virusObject = restTemplate.getForObject(RUD_VIRUS_BY_ID, Virus.class, param);
		System.out.println("Virus Name:" + virusObject.getName() + "\n" + "Date Discovered:"+virusObject.getYearDiscovered());
	}
	
	private static void getVirusByIDButNotFound() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 100);
		try {
			restTemplate.getForObject(RUD_VIRUS_BY_ID, Virus.class, param);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private static Virus insertVirus() {
		Virus virusObject = new Virus("NCOVID-4x", "2019");
		
		ResponseEntity<Virus> result = restTemplate.postForEntity(BASE_URL, virusObject, Virus.class);
		System.out.println(result.getBody());
		return result.getBody();
	}
	
	private static void updateVirus(Virus data) {
		Map<String, Long> param = new HashMap<>();
		param.put("id", data.getIdVirus());
		
		Virus virusObject = new Virus("NCOVID-X", "2019");
		restTemplate.put(RUD_VIRUS_BY_ID, virusObject, param);
	}
	
	private static void deleteVirusByID(Virus data) {
		Map<String, Long> param = new HashMap<>();
		param.put("id", data.getIdVirus());
		restTemplate.delete(RUD_VIRUS_BY_ID, param);
	}
	
	private static Symptoms insertSymptons(Long id) {
		String API_URL = BASE_URL +"/"+id+"/symptoms";
		Symptoms mockData = new Symptoms("Fever","moderate to high fever");
		Symptoms mockData2 = new Symptoms("Cough","dry cough");
		Symptoms mockData3 = new Symptoms("Soar Throat","dry throat");

		System.out.println(restTemplate.postForEntity(API_URL, mockData, Symptoms.class).getBody());
		System.out.println(restTemplate.postForEntity(API_URL, mockData2, Symptoms.class).getBody());
		ResponseEntity<Symptoms> result = restTemplate.postForEntity(API_URL, mockData3, Symptoms.class);
		System.out.println(result.getBody());
		return result.getBody();
	}
	
	private static void getSymptonByID(Long id_Virus, Long id_Symptons) {
		Map<String, Long> param = new HashMap<>();
		param.put("v_id", id_Virus);
		param.put("s_id", id_Symptons);
		System.out.println(param);
		Symptoms symptomObject = restTemplate.getForObject(RUD_SYMPTOMS_BY_ID, Symptoms.class, param);
		System.out.println(symptomObject);
	}
	
	private static void getAllSymp(Long id_Virus) {
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Map<String, Long> param = new HashMap<>();
		param.put("v_id", id_Virus);
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", header); 
		
		ResponseEntity<String> result = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class, param);
		
		System.out.println(result);
	}
	
	private static void updateSymptoms(Long v_id, Symptoms symptom) {
		Map<String, Long> param = new HashMap<>();
		param.put("v_id", v_id);
		param.put("s_id", symptom.getIdSymptoms());
		
		restTemplate.put(RUD_SYMPTOMS_BY_ID, symptom, param);
	}
	
	private static void deleteSymptomsByID(Long id_Virus, Long id_Symptons) {
		Map<String, Long> param = new HashMap<>();
		param.put("v_id", id_Virus);
		param.put("s_id", id_Symptons);
		restTemplate.delete(RUD_SYMPTOMS_BY_ID, param);
	}

}
