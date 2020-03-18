package com.ABPApp.ws.rest.dao;

import java.util.ArrayList;

import com.ABPApp.ws.rest.vo.VOCurso;

public class DAOCurso {
	ArrayList<VOCurso> base = new ArrayList<VOCurso>();
	public boolean addCurso(VOCurso user) {
		if(isCurso(user)==false) {
			base.add(user);
			return true;
		}
		return false;
	}
	
	public boolean isCurso(VOCurso vo) {
		for (int i = 0; i < base.size(); i++) {
			if (base.get(i).getNombre() == vo.getNombre()) {
				return true;
			}
		}
		return false;
	}
	
	public VOCurso isCursoName(String name) {
		for (int i = 0; i < base.size(); i++) {
			if (base.get(i).getNombre() == name) {
				return base.get(i);
			}
		}
		return null;
	}
}