package br.com.gameshunter.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class ProjetoDeLeitorDeJson {

	XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
}