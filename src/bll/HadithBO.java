package bll;

import java.util.ArrayList;

import dal.IDAL;

public class HadithBO implements IBLL {

	private IDAL dao;

	public HadithBO(IDAL dao) {
		this.dao = dao;
	}

	@Override
	public ArrayList<String> getNarratorOfHadithToAGivenNarrator(String narrator) {
		// TODO Auto-generated method stub
		ArrayList<String> sanadArrays = dao.getAllSanad();
		ArrayList<String> finalNarrators = new ArrayList<String>();
		for (int i = 0; i < sanadArrays.size(); i++) {
			String sanadArrayBuilder = sanadArrays.get(i);
			StringBuilder sb = new StringBuilder(sanadArrayBuilder);
			sb.deleteCharAt(sanadArrayBuilder.length() - 1);
			sb.deleteCharAt(0);
			String sanadArray = sb.toString();
			String[] narrators = sanadArray.split(",");
			for (int j = 0; j < narrators.length - 1; j++) {
				if (narrators[j + 1] == narrator && !finalNarrators.contains(narrators[j])) {
					finalNarrators.add(narrators[j]);
				}
			}
		}
		return finalNarrators;
	}

	@Override
	public ArrayList<String> getNarrateorOfHadithFromAGivenNarrator(String narrator) {
		// TODO Auto-generated method stub
		ArrayList<String> sanadArrays = dao.getAllSanad();
		ArrayList<String> finalNarrators = new ArrayList<String>();
		for (int i = 0; i < sanadArrays.size(); i++) {
			String sanadArrayBuilder = sanadArrays.get(i);
			StringBuilder sb = new StringBuilder(sanadArrayBuilder);
			sb.deleteCharAt(sanadArrayBuilder.length() - 1);
			sb.deleteCharAt(0);
			String sanadArray = sb.toString();
			String[] narrators = sanadArray.split(",");
			for (int j = 1; j < narrators.length; j++) {
				if (narrators[j - 1] == narrator && !finalNarrators.contains(narrators[j])) {
					finalNarrators.add(narrators[j]);
				}
			}
		}
		return finalNarrators;
	}

	public static void main(String[] args) {

	}

	@Override
	public ArrayList<String> getUniqueNarratorsInABook(String bookName) {
		// TODO Auto-generated method stub
		ArrayList<String> sanadArrays = dao.getAllSanadsOfABook(bookName);
		ArrayList<String> finalNarrators = new ArrayList<String>();
		for (int i = 0; i < sanadArrays.size(); i++) {
			String sanadArrayBuilder = sanadArrays.get(i);
			StringBuilder sb = new StringBuilder(sanadArrayBuilder);
			sb.deleteCharAt(sanadArrayBuilder.length() - 1);
			sb.deleteCharAt(0);
			String sanadArray = sb.toString();
			String[] narrators = sanadArray.split(",");
			for (int j = 1; j < narrators.length; j++) {
				if (!finalNarrators.contains(narrators[j])) {
					finalNarrators.add(narrators[j]);
				}
			}
		}
		return finalNarrators;
	}

	@Override
	public ArrayList<String> getAllNarratorsAtLevelInABook(String bookName, int level) {
		// TODO Auto-generated method stub
		ArrayList<String> finalNarrators=new ArrayList<>();
		String sanadArrays = dao.getSanadAtLevelOfABook(bookName, level);
		StringBuilder sb = new StringBuilder(sanadArrays);
		sb.deleteCharAt(sanadArrays.length() - 1);
		sb.deleteCharAt(0);
		String sanadArray = sb.toString();
		String[] narrators = sanadArray.split(",");
		for (int j = 1; j < narrators.length; j++) {
			if (!finalNarrators.contains(narrators[j])) {
				finalNarrators.add(narrators[j]);
			}
		}
		return finalNarrators;
	}

}