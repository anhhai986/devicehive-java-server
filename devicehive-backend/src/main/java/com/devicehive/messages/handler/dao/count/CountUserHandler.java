package com.devicehive.messages.handler.dao.count;

/*
 * #%L
 * DeviceHive Backend Logic
 * %%
 * Copyright (C) 2016 DataArt
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.devicehive.dao.UserDao;
import com.devicehive.model.rpc.CountResponse;
import com.devicehive.model.rpc.CountUserRequest;
import com.devicehive.shim.api.Request;
import com.devicehive.shim.api.Response;
import com.devicehive.shim.api.server.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountUserHandler implements RequestHandler {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Response handle(Request request) {

        final CountUserRequest req = (CountUserRequest) request.getBody();

        final long count = userDao.count(req.getLogin(), req.getLoginPattern(), req.getRole(), req.getStatus());

        final CountResponse countResponse = new CountResponse(count);

        return Response.newBuilder()
                .withBody(countResponse)
                .buildSuccess();
    }
}
