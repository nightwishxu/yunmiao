package com.paidang.daoEx;

import com.paidang.daoEx.model.PawnContinueEx;

import java.util.List;
import java.util.Map; /**
@author sun
*/
public interface PawnContinueMapperEx {

    //查看 续当当票
    List<PawnContinueEx> getRepawnTickInfo(String pawnId);

}
