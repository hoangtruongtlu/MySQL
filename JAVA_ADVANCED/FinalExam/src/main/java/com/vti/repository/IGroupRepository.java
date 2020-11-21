package com.vti.repository;

import java.util.List;

import com.vti.entity.Group;

public interface IGroupRepository {

	public List<Group> getAllgroups(int page, int size, String sortType, String sortField, String search, short from,
			short to);
	
	public Group getGroupByID(short id);
	
	public void createGroup(Group Group);

	public void updateGroup(Group Group);

	public void deleteGroup(short id);
}
