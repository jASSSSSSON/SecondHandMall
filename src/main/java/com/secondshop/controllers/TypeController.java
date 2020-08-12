package com.secondshop.controllers;

import com.secondshop.models.FirstType;
import com.secondshop.models.SecondType;
import com.secondshop.services.GoodService;
import com.secondshop.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("type")
public class TypeController {
	private final TypeService typeService;
	private final GoodService goodService;

	/**
	 * 自动装配
	 * @param typeService 分类服务
	 * @param goodService 商品服务
	 */
	@Autowired
	public TypeController(TypeService typeService, GoodService goodService) {
		this.typeService = typeService;
		this.goodService = goodService;
	}

	/**
	 * 获得二级分类
	 * @param firstTypeId 一级分类ID
	 * @return 返回提示信息
	 */
	@RequestMapping(value = "/secondType/{firstTypeId}", method = RequestMethod.GET)
	public ResponseEntity getSecondTypeId(@PathVariable Integer firstTypeId) {
		List<SecondType> secondTypes = typeService
				.getSecondTypeByFirstTypeId(firstTypeId);
		if (secondTypes == null) {
			return ResponseEntity.ok("isNull");
		}
		return ResponseEntity.ok(secondTypes);
	}

	/**
	 * 删除二级分类
	 * @param secondTypeId 二级分类ID
	 * @return 返回提示信息
	 */
	@RequestMapping(value = "/secondType/delete/{secondTypeId}", method = RequestMethod.GET)
	public ResponseEntity deleteSecondType(@PathVariable Integer secondTypeId) {
		Boolean success = goodService.getGoodsAdminByType(secondTypeId)
				.isEmpty();
		System.out.println(goodService.getGoodsAdminByType(secondTypeId));
		if (success) {
			Integer thisFirstTypeId = typeService.getSecondTypeById(
					secondTypeId).getFirstTypeId();
			success = typeService.deleteSecondType(secondTypeId);
			if (success) {
				List<SecondType> secondTypeList = typeService
						.getSecondTypeByFirstTypeId(thisFirstTypeId);
				if (secondTypeList == null) {
					return ResponseEntity.ok("isNull");
				}
				return ResponseEntity.ok(secondTypeList);
			}
		}
		return ResponseEntity.ok(success);
	}

	/**
	 * 删除一级分类
	 * @param firstTypeId 一级分类ID
	 * @return 返回提示信息
	 */
	@RequestMapping(value = "/firstType/delete/{firstTypeId}", method = RequestMethod.GET)
	public ResponseEntity deleteFirstType(@PathVariable Integer firstTypeId) {
		Boolean success = typeService.getSecondTypeByFirstTypeId(firstTypeId)
				.isEmpty();
		if (success) {
			success = typeService.deleteFirstType(firstTypeId);
			if (success) {
				List<FirstType> firstTypeList = typeService.getAllFirstType();
				if (firstTypeList == null) {
					return ResponseEntity.ok("isNull");
				}
				return ResponseEntity.ok(firstTypeList);
			}
		}
		return ResponseEntity.ok(success);
	}

	/**
	 * 二级分类创建
	 * @param secondType 二级分类
	 * @return 返回提示信息
	 */
	@RequestMapping(value = "/secondType/create", method = RequestMethod.POST)
	public ResponseEntity createSecondType(@RequestBody SecondType secondType) {
		Integer thisFirstTypeId = secondType.getFirstTypeId();
		Boolean success = typeService.createSecondType(secondType);
		if (success) {
			List<SecondType> secondTypeList = typeService
					.getSecondTypeByFirstTypeId(thisFirstTypeId);
			return ResponseEntity.ok(secondTypeList);
		}
		return ResponseEntity.ok(success);
	}

	/**
	 * 一级分类创建
	 * @param firstType 一级分类
	 * @return 返回提示信息
	 */
	@RequestMapping(value = "/firstType/create", method = RequestMethod.POST)
	public ResponseEntity createSecondType(@RequestBody FirstType firstType) {
		Boolean success = typeService.createFirstType(firstType);
		if (success) {
			List<FirstType> firstTypeList = typeService.getAllFirstType();
			return ResponseEntity.ok(firstTypeList);
		}
		return ResponseEntity.ok(success);
	}
}
