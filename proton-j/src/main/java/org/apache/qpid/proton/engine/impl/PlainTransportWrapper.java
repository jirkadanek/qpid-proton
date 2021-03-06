/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.apache.qpid.proton.engine.impl;

import java.nio.ByteBuffer;

import org.apache.qpid.proton.engine.TransportException;

public class PlainTransportWrapper implements TransportWrapper
{
    private final TransportOutput _outputProcessor;
    private final TransportInput _inputProcessor;

    public PlainTransportWrapper(TransportOutput outputProcessor,
            TransportInput inputProcessor)
    {
        _outputProcessor = outputProcessor;
        _inputProcessor = inputProcessor;
    }

    @Override
    public int capacity()
    {
        return _inputProcessor.capacity();
    }

    @Override
    public int position()
    {
        return _inputProcessor.position();
    }

    @Override
    public ByteBuffer tail()
    {
        return _inputProcessor.tail();
    }

    @Override
    public void process() throws TransportException
    {
        _inputProcessor.process();
    }

    @Override
    public void close_tail()
    {
        _inputProcessor.close_tail();
    }

    @Override
    public int pending()
    {
        return _outputProcessor.pending();
    }

    @Override
    public ByteBuffer head()
    {
        return _outputProcessor.head();
    }

    @Override
    public void pop(int bytes)
    {
        _outputProcessor.pop(bytes);
    }

    @Override
    public void close_head()
    {
        _outputProcessor.close_head();
    }

}