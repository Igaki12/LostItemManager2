package model;

import java.io.Serializable;

public class Item implements Serializable {
	
	private int id = 0;
	private int item_kind = 0;
	private int found_place = 0;
	private String found_at = "2001/01/01 00:00:00";
	private String photo = null;
	private int pass = 0;
	private int delete_flag = 0;
	private String posted_at = "2001/01/01 00:00:00";
	private String updated_at = null;
	private String deleted_at = null;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItem_kind() {
		return item_kind;
	}

	public void setItem_kind(int item_kind) {
		this.item_kind = item_kind;
	}

	public int getFound_place() {
		return found_place;
	}

	public void setFound_place(int found_place) {
		this.found_place = found_place;
	}

	public String getFound_at() {
		return found_at;
	}

	public void setFound_at(String found_at) {
		this.found_at = found_at;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	public int getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}

	public String getPosted_at() {
		return posted_at;
	}

	public void setPosted_at(String posted_at) {
		this.posted_at = posted_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}

	public Item() {}
	
}