package com.unep.wcmc.integration.fauna;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

@Component
public class FaunaReader implements ItemReader<String[]> {

    protected static final Log logger = LogFactory.getLog(FaunaReader.class);

    private static final String CSV_DATA_FILE = "src/main/resources/data/Taxonomic_ICMBio_brazilian_species.csv";

    private CSVReader reader;

    public String[] read() throws Exception {
        if (reader == null) {
            // CSV fields
            //Reino,Filo,Classe,Ordem,Familia,Genero,Epiteto Especifico,Subespecie,species,Nome cientifico,Nome Comum
            reader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(CSV_DATA_FILE), "UTF-8")));
        }
        return reader.readNext();
    }

}