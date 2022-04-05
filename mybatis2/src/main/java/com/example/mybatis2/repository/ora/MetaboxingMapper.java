package com.example.mybatis2.repository.ora;

import com.example.mybatis2.vo.Metaboxing;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

@OraMapper
public interface MetaboxingMapper {

    List<Metaboxing> findByAllMetaboxing();

    @Insert("INSERT INTO Z_TEMP (FILE_NM, CATEGORY_M, CATEGORY, CLASS_ID_MB, CHECKING) VALUES ('TEST', 'TEST', 'TEST', 'TEST', 'TEST')")
    void insertTest();
}
