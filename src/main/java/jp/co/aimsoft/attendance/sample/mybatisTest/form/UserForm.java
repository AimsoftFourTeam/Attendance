package jp.co.aimsoft.attendance.sample.mybatisTest.form;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class UserForm {

	/** ユーザーID. */
	private String userId;

	/** ユーザー名. */
	private String userName;

	/** 所属. */
	private String department;

	/** 役職. */
	private String position;

	/** パスワード. */
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		Field[] fields = this.getClass().getDeclaredFields();
//		fields.stream().
		Stream.of(fields).forEach(field -> this.setItemPropeties(sb, field));

		return sb.toString();
	}

	protected void setItemPropeties(StringBuilder sb, Field field) {

		// TODO 今は、Nestされたクラスについては未対応。

		try {
			field.setAccessible(true);
			sb.append(field.getName());
			sb.append(":");
			sb.append(field.get(this));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// 何もしない
		} finally {
			sb.append(",");
		}
	}
}
