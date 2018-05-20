import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {successstories} from './successstories';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable()
export class SuccessStoriesService {

  private entity_url = environment.REST_API_URL +'/allsuccessstories';

  constructor(private _http: Http) {
  }

  getOwners(): Observable<successstories[]> {
    alert(this.entity_url);
    return this._http.get(this.entity_url)
      .map((response: Response) => <successstories[]> response.json())
      .catch(this.handleError);
  }
/*
  getOwnerById(owner_id: string): Observable<Owner> {
    return this._http.get((this.entity_url + '/' + owner_id))
      .map((response: Response) => <Owner> response.json())
      .catch(this.handleError);
  }

  addOwner(owner: Owner): Observable<Owner> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'application/json');
    return this._http.post(this.entity_url, JSON.stringify(owner), {headers})
      .map((response: Response) => <Owner> response.json())
      .catch(this.handleError);
  }

  updateOwner(owner_id: string, owner: Owner): Observable<Owner> {
    const body = JSON.stringify(owner);
    const headers = new Headers({'Content-Type': ' application/json;charset=UTF-8'});
    const options = new RequestOptions({headers: headers});
    return this._http.put((this.entity_url + '/' + owner_id), body, options)
      .map((response: Response) => response)
      .catch(this.handleError); // TODO parse response header when error ?
  }

  deleteOwner(owner_id: string): Observable<Owner> {
    return this._http.delete((this.entity_url + '/' + owner_id))
      .map((response: Response) => <Owner> response.json())
      .catch(this.handleError);
  }
*/
  private handleError(error: Response | any) {
    console.log('handleError log: ');
    let errMsg: string;
    if (error instanceof Response) {
      if (!(error.text() === '' )) {  // if response body not empty
        const body = error.json() || '';
        const err = body.error || JSON.stringify(body);
        errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
      } else {
        console.log('binding errors header not empty');
        errMsg = error.headers.get('errors').toString();
      }
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }


}
