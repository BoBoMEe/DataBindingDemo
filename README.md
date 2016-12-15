# DataBindingDemos
----

[English README](https://github.com/BoBoMEe/DataBindingDemo/blob/master/README.md)

## DataBinding RecyclerViewAdapter

此`Adapter`基于 [markzhai/DataBindingAdapter](https://github.com/markzhai/DataBindingAdapter) 和 [tianzhijiexian/CommonAdapter](https://github.com/tianzhijiexian/CommonAdapter) 改编而来
结合了二者的特性，使`Adapter`使用起来更简单，支持多种`type`和`databinding`。

## Get Started


`AdapterItem`:

```Java
public class EmployeeItem implements AdapterItem<EmployeeViewModel> {
  //...
  @Override public int getLayoutResId() {
    return R.layout.item_employee;
  }

  @Override public Presenter getPresenter() {
    return new EmployeePresenter();
  }

  @Override public Decorator getDecorator() {
    return new Decorator() {
      @Override public void decorator(BindingViewHolder holder, int position, int viewType) {
      //...
      }
    };
  }

  public class EmployeePresenter implements Presenter {
   //...
  }
}
```

`CommonAdapter`:

```Java
public class MainAdapter extends CommonAdapter {
//...
  @NonNull @Override public AdapterItem createItem(int viewType) {
    return adapterItem;//
  }

  @Override public int getViewType(Object _o) {
    return  viewType;//
  }
}

```

限制: 命名规范：你的 ViewModel 在 xml 中的明明必须为 `item`，而你的 事件监听对象 必须被命名为 `presenter`，我认为这对 Data Binding 来说是一种最佳实践。

## 事件监听

使用 `databinding` 的 事件处理方式

```java
holder.getBinding().setVariable(BR.item, item);
    holder.getBinding()
        .setVariable(BR.presenter, adapterItem.getPresenter());
```

## 装饰器

有时候，我们想在 `onBindViewHolder` 做些额外的事（比如根据 position 隐藏显示一些东西），所以额外提供了一个 `Decorator` 来让你实现并 set 进去。

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