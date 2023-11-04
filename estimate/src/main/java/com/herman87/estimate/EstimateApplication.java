package com.herman87.estimate;

import com.herman87.estimate.dto.EntryDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class  EstimateApplication {

	public static void main(String[] args) throws JRException {
		SpringApplication.run(EstimateApplication.class, args);
		String filePath = "C:\\H87\\estimate\\estimate\\src\\main\\resources\\templates\\estimateReport.jrxml";

		EntryDTO entryDTO1 = EntryDTO.builder()
				.designation("article 1")
				.unitPrice(1000d)
				.quantity(1)
				.total(0d)
				.build();
		EntryDTO entryDTO2 = EntryDTO.builder()
				.designation("article 2")
				.unitPrice(5000d)
				.quantity(4)
				.total(0d)
				.build();
		EntryDTO entryDTO3 = EntryDTO.builder()
				.designation("article 3")
				.unitPrice(700d)
				.quantity(10)
				.total(0d)
				.build();
		EntryDTO entryDTO4 = EntryDTO.builder()
				.designation("article 4")
				.unitPrice(900d)
				.quantity(2)
				.total(0d)
				.build();
		EntryDTO entryDTO5 = EntryDTO.builder()
				.designation("article 5")
				.unitPrice(3500d)
				.quantity(1)
				.total(0d)
				.build();

        List<EntryDTO> entryDTOList = new ArrayList<>(List.of(entryDTO1, entryDTO2, entryDTO3, entryDTO4, entryDTO5));

		JRBeanCollectionDataSource estimateDataSource = new JRBeanCollectionDataSource(entryDTOList);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("productDataSet", estimateDataSource);

		JasperReport report = JasperCompileManager.compileReport(filePath);
		JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print, "C:\\H87\\estimate\\estimate\\src\\main\\resources\\static\\estimate.pdf");
		System.out.println("Report generated successfully");
	}

}
	