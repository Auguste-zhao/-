# 个人进行知识复习整合的前后端分离项目的后台部分
## 安装运行提前准备说明

- test_20220525123227_backup.sql 是本项目的数据库数据，安装MySQL之后导入
- 本项目的购物车使用到了Redis数据库，需要提前安装
- 本项目使用了MySql，需要提前安装



## backstage 是本项目的后台接口，直接导入IDEA之后，运行，

---

运行端口：8081



## Background management of auto accessories 是本项目的后台管理系统。

---

```bash
npm install -g yarn
yarn install
yarn dev
```

默认端口：9091



## cart_shopping 是本项目的购物商城

---

```bash
yarn install
yarn dev
```

默认端口：3000



## 登录使用说明

---

​	数据库名称：augu 密码：123456
​	管理员初始账户：bywind 初始密码：123456；
​	销售员可以在后台管理系统进行添加
​	用户可以在购物商城注册后登录使用



## 使用说明

- 管理员想要登录基于web的饰品店管理系统的后台管理页面需要输入管理员的正确的并符合格式要求的账号和密码方可进入后台管理系统页面的首页界面。
- 管理员登录后，系统显示dashboard界面。所有资源都会显示出来，右上角会显示库存不足的信息
  	登录后，管理员可以在后台对产品信息进行添加、删除、修改、查看等操作
- 管理员登录系统进入仓库管理可以按仓库对库存的商品进行操作
- 管理员可以查看、添加和管理所有管理员信息
- 管理员可以对销售员信息进行查看、增加和管理，并可以点击销售量的箭头来升序或者降序排序，以便能更加直观的看到业绩的排名
- 管理员可以查看、修改和管理客户信息，并可以通过点击删除按钮删除用户信息
- 管理员拥有对全部的发生的交易行为的交易订单记录信息进行查看和管理，管理员可以点击详情按钮来查看该笔订单的具体内容，以便于留下票据存根
- 管理员可以进行公告的发布，其中的文本是富文本编辑器，可以当成word一样来用
- 管理员可以对发布过的全部公告进行充分权限的查看、管理和删除，点击删除按钮可以删除已经失效的公告
- 用户/销售员进入系统后可以查看网站的首页进行信息的了解和商品的浏览
- 客户或销售人员使用用户名和密码登录。单击密码字段中的按钮，可以确定密码是否以明文形式显示。
- 新客户通过使用用户名和密码进行注册，密码栏可以点击按钮，实现是否明文显示密码，在按提示的要求成功注册后会提示并切换到登录页面
- 客户可以在在线商城进行商品的浏览和点击想要的商品下方的按钮进行选购，点击想要的商品下方的加入购物车就可以将商品加入购物车（如果商品余量不足时就会提示商品余量不足），需要搜索指定商品时，在右上角的搜索框输入你想要完成检索的商品的关键字、关键词、关键描述都可以，即可完成搜索。
- 用户在自己购物车中可以看到全部自己添加的商品，购物车最下方会动态显示购物车中的商品数量和总价。用户点击“去结账”按钮之后会弹出移动支付的页面，在扫码支付成功完成之后会跳转到订单页面。
- 用户对自己的信息进行查看或修改等操作。
