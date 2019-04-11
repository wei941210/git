import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './frame/login/login.component';
import {MainframeComponent} from './frame/mainframe/mainframe.component';
import {WelcomeComponent} from './frame/welcome/welcome.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login' , component : LoginComponent},  // 登录页面
  {path: 'mainframe', component: MainframeComponent,
    children: [
      {path : '' , redirectTo : 'welcome', pathMatch: 'full'},
      {path : 'welcome' , component : WelcomeComponent},
      {path: 'advertmgr' , loadChildren: './advert-mgr/advert-mgr.module#AdvertMgrModule', data : {preload : true}}, // 广告管理
      {path: 'ordermgr' , loadChildren: './order-mgr/order-mgr.module#OrderMgrModule', data : {preload : true}}, // 订单管理
      {path: 'devicemgr' , loadChildren: './device-mgr/device-mgr.module#DeviceMgrModule', data : {preload : true}}, // 设备管理
      {path: 'advertputinmonitor' , loadChildren: './advert-putin-monitor/advert-putin-monitor.module#AdvertPutinMonitorModule', data : {preload : true}}, // 广告投放流程监控
      {path: 'analysis' , loadChildren: './analysis/analysis.module#AnalysisModule', data : {preload : true}}, // 统计分析
      {path: 'dictionary' , loadChildren: './dictionary/dictionary.module#DictionaryModule', data : {preload : true}}, // 字典管理
      {path: 'sys' , loadChildren: './sys/sys.module#SysModule', data : {preload : true}}, // 系统管理

    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
