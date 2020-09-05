package com.example.demo.service;

import com.example.demo.beans.Item;
import com.example.demo.data.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

//@RunWith(MockitoJunitRunner.class)
// assertThat() -> Junit5 -> u have to use from hamcrest lib, for Junit4 -> u can use from Junit lib
// @InjectMocks,@MockBean -> for Impl
// @Mock -> interface
@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceImplTest {

    @InjectMocks
    ItemBusinessServiceImpl itemBusinessServiceImpl;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void retriveAllItemTest() {
        given(itemRepository.findAll()).willReturn(Arrays.asList(
                new Item("youghurt",1,10.00,100),
                new Item("fries",2,20.00,100)
        ));
        List<Item> items = itemBusinessServiceImpl.retriveAllItem();
        assertThat(items,hasSize(2));
        assertThat(items.get(0).getValue(), is(1000.0));
        assertThat(items.get(1).getValue(), is(2000.0));
    }


}