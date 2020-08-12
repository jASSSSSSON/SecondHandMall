package com.secondshop.services;

import com.secondshop.mappers.FirstTypeMapper;
import com.secondshop.mappers.SecondTypeMapper;
import com.secondshop.models.FirstType;
import com.secondshop.models.SecondType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeService {
	@Autowired
	private FirstTypeMapper firstTypeMapper;
	@Autowired
	private SecondTypeMapper secondTypeMapper;

	/**
	 * 取得所有第一分类
	 * @return 返回集合
	 */
	@Transactional
	public List<FirstType> getAllFirstType() {
		return firstTypeMapper.getAllFirstType();
	}

	/**
	 * 通过第一分类ID获取所有第二分类
	 * @param firstTypeId 一级分类ID
	 * @return 返回集合
	 */
	@Transactional
	public List<SecondType> getSecondTypeByFirstTypeId(int firstTypeId) {
		return secondTypeMapper.getSecondTypeByFirstTypeId(firstTypeId);
	}

	/**
	 * 根据ID获取二级分类
	 * @param secondTypeId 二级分类ID
	 * @return 返回搜索结果
	 */
	@Transactional
	public SecondType getSecondTypeById(int secondTypeId) {
		return secondTypeMapper.getSecondTypeById(secondTypeId);
	}

	/**
	 * 创建一级分类
	 * @param firstType 一级分类
	 * @return 返回创建结果
	 */
	@Transactional
	public Boolean createFirstType(FirstType firstType) {
		Integer firstTypeId = firstTypeMapper.getFirstTypeLastId();
		if (firstTypeId == null) {
			firstTypeId = 1000;
		}
		firstType.setId(firstTypeId + 1);
		return firstTypeMapper.createFirstType(firstType) > 0;
	}

	/**
	 * 创建二级分类
	 * @param secondType 二级分类
	 * @return 返回创建结果
	 */
	@Transactional
	public Boolean createSecondType(SecondType secondType) {
		Integer firstTypeId = secondTypeMapper.getSecondTypeLastId(secondType
				.getFirstTypeId());
		if (firstTypeId == null) {
			firstTypeId = secondType.getFirstTypeId() * 1000;
		}
		secondType.setId(firstTypeId + 1);
		return secondTypeMapper.createSecondType(secondType) > 0;
	}

	/**
	 * 删除一级分类
	 * @param firstTypeId 一级分类ID
	 * @return 返回删除结果
	 */
	@Transactional
	public Boolean deleteFirstType(Integer firstTypeId) {
		return firstTypeMapper.deleteFirstType(firstTypeId) > 0;
	}

	/**
	 * 删除二级分类
	 * @param secondTypeId 二级分类ID
	 * @return 返回删除结果
	 */
	@Transactional
	public Boolean deleteSecondType(Integer secondTypeId) {
		return secondTypeMapper.deleteSecondType(secondTypeId) > 0;
	}
}
