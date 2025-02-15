.. _ref-create-user:

===============
``CREATE USER``
===============

Create a new database user.

.. rubric:: Table of contents

.. contents::
   :local:

Synopsis
========

.. code-block:: psql

  CREATE USER username
  [ WITH ( user_parameter = value [, ...]) ] |
  [ [ WITH ] user_parameter [value] [ ... ] ]

Description
===========

``CREATE USER`` is a management statement to create a new database user in the
CrateDB cluster. The newly created user does not have any special privileges.
The created user can be used to authenticate against CrateDB, see
:ref:`admin_hba`.

The statement allows to specify a password for this account. This is not
necessary if password authentication is disabled.

For usage of the ``CREATE USER`` statement see
:ref:`administration_user_management`.

Parameters
==========

:username:
  The unique name of the database user.

  The name follows the principles of a SQL identifier (see
  :ref:`sql_lexical_keywords_identifiers`).

Clauses
=======

``WITH``
--------

The following ``user_parameter`` are supported to define a new user account:

:password:
  The password as cleartext entered as string literal. e.g.::

     CREATE USER john WITH (password='foo')

  ::

     CREATE USER john WITH password='foo'

  ::

     CREATE USER john WITH password 'foo'

  ::

     CREATE USER john password 'foo'
