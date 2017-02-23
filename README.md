# DataBindingDemos
----

[中文版 README](https://github.com/BoBoMEe/DataBindingDemo/blob/master/README_CN.md)

## DataBinding RecyclerViewAdapter

Super simple RecyclerView adapter using Data Binding Technology, no longer need to write any adapter! You don't need to write any extra class like ViewHolder or ItemView.

It`s Based on [markzhai/DataBindingAdapter](https://github.com/markzhai/DataBindingAdapter) and [tianzhijiexian/CommonAdapter](https://github.com/tianzhijiexian/CommonAdapter)

Combined with the Characteristics of the two, make `Adapter` easier to use

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

## Listener Binding

An easy way to add listener binding

```java
 holder.getBinding().setVariable(key, value);
```
Do not have their own settings, only need to set up presenter，Such as：

```java
 public class EmployerPresenter {//presenter
    public void onItemClick(EmployerViewModel model) {
      Toast.makeText(context, "employer " + model.name, Toast.LENGTH_SHORT).show();
    }
  }
```

## Decorator

A Decorator is provided to let user implement and set ,With it we can do some extra works in onBindViewHolder

```java
AdapterItem.Decorator decorator = adapterItem.getDecorator();

if (decorator != null) {
      decorator.decorator(holder, position, getItemViewType(position));
}

//adapter
@Override public Decorator getDecorator() {
    return null; // return AdapterItem.Decorator
  }
```

# Thanks

- [markzhai/DataBindingAdapter](https://github.com/markzhai/DataBindingAdapter)
- [tianzhijiexian/CommonAdapter](https://github.com/tianzhijiexian/CommonAdapter)

# Links

- [Android MVVM 之DataBinding,BindingAdapter及component](http://blog.csdn.net/wbwjx/article/details/53638715)

# License

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
