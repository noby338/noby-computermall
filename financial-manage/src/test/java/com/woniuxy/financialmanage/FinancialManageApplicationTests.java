package com.woniuxy.financialmanage;

import com.woniuxy.commonentity.entity.Model;
import com.woniuxy.commonentity.entity.Store;
import com.woniuxy.financialmanage.service.ModelService;
import com.woniuxy.financialmanage.service.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FinancialManageApplicationTests {
    @Autowired
    ModelService modelService;
    @Autowired
    StoreService storeService;

    /**
     * 修改库存
     */
    @Test
    void test() {
        for (int i = 1; i <= 20; i++) {
            Store store = storeService.queryById(i);
            List<Model> modelList = store.getModelList();
            int totalNum = 0;
            for (Model model : modelList) {
                totalNum += model.getNum();
            }
            store.setNum(totalNum);
            storeService.update(store);
        }
    }

    /**
     * 修改销售价格
     */
    @Test
    void test2() {
        for (int i = 1; i <= 46; i++) {
            Model model = modelService.queryById(i);
            Double purchasePrice = model.getPurchasePrice();
            model.setSalePrice(purchasePrice*1.4);
            modelService.update(model);
        }
    }

}
