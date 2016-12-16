# DataBindingDemos
----

[English README](https://github.com/BoBoMEe/DataBindingDemo/blob/master/README.md)

## DataBinding RecyclerViewAdapter

此`Adapter`基于 [markzhai/DataBindingAdapter](https://github.com/markzhai/DataBindingAdapter) 和 [tianzhijiexian/CommonAdapter](https://github.com/tianzhijiexian/CommonAdapter) 改编而来
结合了二者的特性，使`Adapter`使用起来更简单，支持多种`type`和`databinding`。

是 databing 在 Recyclerview.Adapter 上的实践。

## Get Started


`AdapterItem`:

```Java
public class EmployerItem implements AdapterItem<EmployerViewModel> {
//...
  @Override public int getLayoutResId() {
    return R.layout.item_employer;// layout res
  }

  @Override public Integer getVariableId() {
    return BR.item; // xml中的item
  }

  @Override public Decorator getDecorator() {
    return null; // item Decorator
  }

  @Override public Map<Integer, Object> getBindData() {
    Map<Integer, Object> map = new HashMap<>();
    map.put(BR.presenter, new EmployerPresenter());
    return map; // item <-> Variable
  }

  public class EmployerPresenter {//presenter
    public void onItemClick(EmployerViewModel model) {
      Toast.makeText(context, "employer " + model.name, Toast.LENGTH_SHORT).show();
    }
  }
}
```

注意： 需要在`bindData`中返回 `item` 和 `variable` 的键值对，`getVariableId`中指定`ViewModel`的 `item`。

`CommonAdapter`:

```Java
public class MainAdapter extends CommonAdapter {
  //...
  @NonNull @Override public AdapterItem createItem(int viewType) {
    return adapterItem;
  }

  @Override public int getViewType(Object _o) {
    return viewType;
  }
}
```

## 事件监听

使用 `databinding` 的 事件处理方式

```java
 holder.getBinding().setVariable(key, value);
```

## 装饰器

使用`Decorator`接口，可以在 `onBindViewHolder` 做些额外的事（比如根据 position 隐藏显示一些东西）。

```java
AdapterItem.Decorator decorator = adapterItem.getDecorator();

    if (decorator != null) {
      decorator.decorator(holder, position, getItemViewType(position));
    }
```

# 感谢

- [markzhai/DataBindingAdapter](https://github.com/markzhai/DataBindingAdapter)
- [tianzhijiexian/CommonAdapter](https://github.com/tianzhijiexian/CommonAdapter)

# 协议

    Copyright (C) 2016 BoBoMEe (wbwjx115@gmail.com).

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.