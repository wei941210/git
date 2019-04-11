import { Injectable } from '@angular/core';
import {Observable, of, Subject} from 'rxjs';
import {DeviceService} from '../../device-mgr/service/device.service';
import {AllDevice} from '../../entity/AllDevice';
import {catchError, map} from 'rxjs/operators';

// 所有设备列表
@Injectable({
  providedIn: 'root'
})
export class AllDeviceService {
  private _deviceList: Array<AllDevice> = new Array<AllDevice>();
  constructor(private devicesvr: DeviceService) { }
  Init(): Observable<boolean> {
    if (this._deviceList.length === 0) {
     return  this.devicesvr.onAllDeviceList().pipe(
                map(alldeviceList => {
                  this._deviceList = alldeviceList;
                  return true;
                }),
               catchError(() =>
                 of(false)
               )
             );
    } else {
       return of(true);
    }

  }
  Get() {
      return this._deviceList;
  }
}
